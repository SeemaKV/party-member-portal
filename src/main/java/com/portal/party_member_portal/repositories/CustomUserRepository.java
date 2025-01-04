package com.portal.party_member_portal.repositories;

import com.portal.party_member_portal.dto.DistrictMemberDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomUserRepository extends UserRepository {
    @Query("SELECT new com.portal.party_member_portal.dto.DistrictMemberDto(u.name, d.name, r.name) " +
            "FROM User u " +
            "JOIN u.district d " +
            "JOIN u.role r " +
            "WHERE u.phoneNumber = :phoneNumber")
    DistrictMemberDto findDistrictMemberDetails(@Param("phoneNumber") String phoneNumber);
}



