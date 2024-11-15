package com.portal.party_member_portal.dto;

import com.portal.party_member_portal.entities.GramPanchayat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalukMemberDto extends MemberDto{
    private String talukName;
    List<GramPanchayatMemberDto> GramPanchayatMemberDto;
}
