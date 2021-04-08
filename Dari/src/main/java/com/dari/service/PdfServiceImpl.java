package com.dari.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.LoansSimulationBank;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;





@Service
public class PdfServiceImpl implements PdfService {

	@Autowired
	private LoansService loanservice;
	
	@Override
	public String toPDF(Long idloan) 
	{
		String URL_file = null;
		
		LoansSimulationBank simulation = loanservice.getLoansById(idloan);
		

		Date d = new Date();
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("yyyyMMdd_HHmmss");
		

		try {
			try {
				try {
					try {
		
		URL_file = "C:\\Users\\AFEF\\Desktop\\ESTIMATION_" + idloan + "_" + formater.format(d)
		+ ".pdf";
		
		OutputStream file = new FileOutputStream(new File(URL_file));
		
		
		Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.GRAY);
		Font catFont15B = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
		Font catFont17Bcour = new Font(Font.FontFamily.COURIER, 17, Font.BOLD, BaseColor.BLACK);
		Font catFont14Bcour = new Font(Font.FontFamily.COURIER, 14, Font.BOLD, BaseColor.BLACK);
		Font subFontPara13B = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
		Font subFontPara13N = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLACK);
		Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);

		Document my_pdf_report = new Document();
		PdfWriter.getInstance(my_pdf_report, file);
		my_pdf_report.open();

		// Dateeee
		DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
		String dt = df.format(new Date());
		Paragraph dateStr = new Paragraph("date: " + dt, catFont15B);
		dateStr.setAlignment(Element.ALIGN_RIGHT);
		
		// espaceee
		Paragraph espace = new Paragraph(" ", subFont);
		espace.setAlignment(Element.ALIGN_LEFT);
		
		// para1
		Paragraph para1 = new Paragraph("Mr,Mms " + simulation.getUser().getFirstName()
				+ " " + simulation.getUser().getLastName(), catFont15B);
		para1.setAlignment(Element.ALIGN_LEFT);
		Paragraph para2 = new Paragraph(
				"Dari team is glad to provide a simulation system "
						+ "for your demande of credit .",
				subFontPara13N);
		para2.setAlignment(Element.ALIGN_LEFT);
		
		// titreee
		Paragraph titre1 = new Paragraph("YOUR INFORMATION", catFont15B);
		titre1.setAlignment(Element.ALIGN_CENTER);
		
		// table declaration
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(90);

		//Ligne 1
		PdfPCell Cellnom = new PdfPCell(new Phrase("First Name & Last Name"+": " + simulation.getUser().getFirstName() + " "
				+ simulation.getUser().getLastName(), subFontPara13B));
		Cellnom.setBorder(Rectangle.NO_BORDER);
		Cellnom.setBackgroundColor(BaseColor.WHITE);
		table.addCell(Cellnom);
		
		//Ligne 2
		PdfPCell CellEmail = new PdfPCell(new Phrase("Email :" + simulation.getUser().getEmail(), subFontPara13B));
		CellEmail.setBorder(Rectangle.NO_BORDER);
		CellEmail.setBackgroundColor(BaseColor.WHITE);
		table.addCell(CellEmail);
		
		//Ligne 3
		PdfPCell Celsal = new PdfPCell(new Phrase("salary :" + simulation.getSalaire(), subFontPara13B));
		Celsal.setBorder(Rectangle.NO_BORDER);
		Celsal.setBackgroundColor(BaseColor.WHITE);
		table.addCell(Celsal);
		
		//break
		Paragraph separator = new Paragraph(
				"_______________________________________________________________________________",
				subFontPara13N);
		separator.setAlignment(Element.ALIGN_CENTER);
		
		// titreee
		Paragraph titre2 = new Paragraph("BANQUE", catFont15B);
		titre2.setAlignment(Element.ALIGN_CENTER);
		
		//table 2
		PdfPTable table1 = new PdfPTable(4);
		table1.setWidthPercentage(90);
		
		//ligne1
		PdfPCell Celbankname = new PdfPCell(new Phrase("Bank :" + simulation.getBank().getNamebank(), subFontPara13B));
		Celbankname.setBorder(Rectangle.NO_BORDER);
		Celbankname.setBackgroundColor(BaseColor.WHITE);
		table1.addCell(Celbankname);
		
		//ligne2
		PdfPCell Celagentname = new PdfPCell(new Phrase("Agent :" + simulation.getAgent().getFirstname() + "   " +simulation.getAgent().getLastname(),catFont15B));
		Celagentname.setBorder(Rectangle.NO_BORDER);
		Celagentname.setBackgroundColor(BaseColor.WHITE);
		table1.addCell(Celagentname);
		
		//ligne3
				PdfPCell Celbankadd = new PdfPCell(new Phrase("Bank address :" + simulation.getBank().getAdressbank() + catFont15B));
				Celbankadd.setBorder(Rectangle.NO_BORDER);
				Celbankadd.setBackgroundColor(BaseColor.WHITE);
				table1.addCell(Celbankadd);
		//ligne4
				PdfPCell Celtm = new PdfPCell(new Phrase("A.M.R :" + simulation.getBank().getTaux() + catFont15B));
				Celtm.setBorder(Rectangle.NO_BORDER);
				Celtm.setBackgroundColor(BaseColor.WHITE);
				table1.addCell(Celtm);
				
		//ligne5
				PdfPCell Celmarg = new PdfPCell(new Phrase("Interet bank margin:" + simulation.getBank().getMargeInteretbank() + catFont15B));
				Celmarg.setBorder(Rectangle.NO_BORDER);
				Celmarg.setBackgroundColor(BaseColor.WHITE);
				table1.addCell(Celmarg);	
				
		
// fiin P1
				Paragraph finPage1 = new Paragraph(" Page 1/2", smallBold);
				finPage1.setAlignment(Element.ALIGN_RIGHT);	
				
			//title
				Paragraph titre21 = new Paragraph("ESTIMATION : ", catFont17Bcour);
				titre21.setAlignment(Element.ALIGN_CENTER);		
				
//table 3	
				PdfPTable table3 = new PdfPTable(4);
				table3.setWidthPercentage(50);
				
		//ligne6
				PdfPCell Celtaux = new PdfPCell(new Phrase("Rate :" + simulation.getTaux() + catFont15B));
				Celtaux.setBorder(Rectangle.NO_BORDER);
				Celtaux.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(Celtaux);	
		//ligne7
				PdfPCell Celmtaux = new PdfPCell(new Phrase("Monthly rate :" + simulation.getMensuel() + catFont15B));
				Celmtaux.setBorder(Rectangle.NO_BORDER);
				Celmtaux.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(Celmtaux);	
		//ligne8
				PdfPCell Celcapacity = new PdfPCell(new Phrase("Repayment capacity :" + simulation.getCapaciteRembouresement() + catFont15B));
				Celcapacity.setBorder(Rectangle.NO_BORDER);
				Celcapacity.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(Celcapacity);	
		//ligne9
				PdfPCell Celmp= new PdfPCell(new Phrase("Monthly payment :" + simulation.getCapaciteRembouresement() + catFont15B));
				Celmp.setBorder(Rectangle.NO_BORDER);
				Celmp.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(Celmp);		
				
		//lligne10
				PdfPCell CelBI= new PdfPCell(new Phrase("Bank interest :" + simulation.getInteret() + catFont15B));
				CelBI.setBorder(Rectangle.NO_BORDER);
				CelBI.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(CelBI);	
		//lligne11
				PdfPCell Celp= new PdfPCell(new Phrase("princper :" + simulation.getPrincipale() + catFont15B));
				Celp.setBorder(Rectangle.NO_BORDER);
				Celp.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(Celp);	
		//lligne12
				PdfPCell CelRA= new PdfPCell(new Phrase("Refund Amount :" + simulation.getMontantRemb() + catFont15B));
				CelRA.setBorder(Rectangle.NO_BORDER);
				CelRA.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(CelRA);
		//lligne13
				PdfPCell CelBIT= new PdfPCell(new Phrase("Bank Total interest :" + simulation.getInteretall() + catFont15B));
				CelBIT.setBorder(Rectangle.NO_BORDER);
				CelBIT.setBackgroundColor(BaseColor.WHITE);
				table3.addCell(CelBIT);
				
	    // fiin P2
				Paragraph finPage2 = new Paragraph(" Page 2/2", smallBold);
				finPage2.setAlignment(Element.ALIGN_RIGHT);
		
						
		
				my_pdf_report.add(dateStr);
				my_pdf_report.add(espace);

				my_pdf_report.add(para1);
				my_pdf_report.add(para2);

				my_pdf_report.add(espace);
				my_pdf_report.add(titre1);

				my_pdf_report.add(table);

				my_pdf_report.add(espace);
				my_pdf_report.add(separator);

				my_pdf_report.add(titre2);
		
				my_pdf_report.add(table1);

	
				my_pdf_report.add(finPage1);

				my_pdf_report.newPage();

				my_pdf_report.add(titre21);
			
				my_pdf_report.add(table3);
				my_pdf_report.add(espace);
				
			
				my_pdf_report.add(finPage2);

				my_pdf_report.close();
				file.close();
				
				Runtime.getRuntime()
				.exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\AFEF\\Desktop\\PDF\\ESTIMATION_"
						+ idloan + "_" + formater.format(d) + ".pdf");
		// p.waitFor(2, TimeUnit.SECONDS);
				
						} catch (FileNotFoundException e) {
						e.printStackTrace();
						}
			} catch (DocumentException e) {
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	} catch (IOException e) {
		e.printStackTrace();
	}
		return "ESTIMATION_" + idloan + "_" + formater.format(d) + ".pdf";
	}
}