package com.dari.repository;

import org.springframework.data.repository.CrudRepository;

import com.dari.model.Agent;

public interface AgentRepository extends CrudRepository<Agent,Long> {

	//@Query(value = "SELECT * FROM t_bank b join user u on u.id=b.agent_bank_id WHERE u.dtype='Agent' AND b.name_bank=?1",nativeQuery=true)
    //public Agent getAgentByNameBank(String nameBank);
}
