package com.portal.party_member_portal.repositories;

import com.portal.party_member_portal.dto.MemberDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;

@Repository
public interface CustomeUserRepository extends UserRepository {



    /*@Query(nativeQuery = true, value = "SELECT u.name, d.name, t.name, g.name, r.name\n" +
            "FROM user u\n" +
            "INNER JOIN district d ON u.district_id = d.id\n" +
            "INNER JOIN role r ON u.role_id = r.id\n" +
            "WHERE u.phone_number = 'phone_number';")
    public MemberDto findDistrictMemberDetails(@PathParam("phone_number") String phoneNumber);
    *//*public User findBygramPanchayatId();*//*
    public MemberDto findTalukMemberDetails(String phoneNumber);*/
}
