package com.portal.party_member_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@Component
public class DistrictMemberDto {
    private String userName;
    private String districtName;
    private String roleName;

    public DistrictMemberDto(String userName, String districtName, String roleName) {
        this.userName = userName;
        this.districtName = districtName;
        this.roleName = roleName;
    }

}
