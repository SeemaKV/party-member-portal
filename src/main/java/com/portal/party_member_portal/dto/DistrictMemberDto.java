package com.portal.party_member_portal.dto;

import com.portal.party_member_portal.entities.GramPanchayat;
import com.portal.party_member_portal.entities.Taluk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictMemberDto extends MemberDto{
    String districtName;
    List<TalukMemberDto> TalukMemberDto;
    List<GramPanchayatMemberDto> GramPanchayatMemberDto;
    /*List<GramPanchayat> gramPanchayatList;
    String message;*/
}
