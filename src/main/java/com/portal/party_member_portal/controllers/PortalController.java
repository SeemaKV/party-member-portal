package com.portal.party_member_portal.controllers;

import com.portal.party_member_portal.dto.DistrictMemberDto;
import com.portal.party_member_portal.entities.*;
import com.portal.party_member_portal.services.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memberportal")
public class PortalController {
    @Autowired
    PortalService portalService;
    @PostMapping("/adddistrict")
    public void addDistrict(@RequestBody District district){
        portalService.addDistrict(district);
    }
    @PostMapping("/adddistricts")
    public void addAllDistricts(@RequestBody List<District> districts){
        portalService.addAllDistricts(districts);
    }
    @PostMapping("/addtaluk")
    public void addTaluk(Taluk taluk){
        portalService.addTaluk(taluk);
    }
    @PostMapping("/addAlltaluks")
    public void addAlltaluks(List<Taluk> taluks){
        portalService.addAlltaluks(taluks);
    }
   /* @PostMapping("/addTaluks/{districtId}")
    public void addTaluks(@PathVariable int districtId, @RequestBody List<Taluk> taluks){
        portalService.addTaluks(districtId, taluks);
    }*/
    @PostMapping("/addgrampanchayat")
    public void addGramPanchayat(GramPanchayat gramPanchayat){
        portalService.addGramPanchayat(gramPanchayat);
    }
    @PostMapping("/addgrampanchayats")
    public void addGramPanchayats(List<GramPanchayat> gramPanchayats){
        portalService.addGramPanchayats(gramPanchayats);
    }
    @PostMapping("/add-role")
    public void addRole(@RequestBody Role role){

        portalService.addRole(role);
    }
    @PostMapping("/add-roles")
    public void addRoles(List<Role> roles){

        portalService.addRoles(roles);
    }
    @PostMapping("/addpollingstation")
    public void addPollingStationDetail(PollingStationDetail pollingStationDetail){
        portalService.addPollingStationDetails(pollingStationDetail);
    }
    @PostMapping("/addpollingStationdetailslist")
    public void addPollingStationsDeatils(List<PollingStationDetail> pollingStationDetailList){
        portalService.addPollingStationsDeatils(pollingStationDetailList);
    }
    @PostMapping("/addvotingdetails")
    public void addVotingDetails(VotingDetail votingDetail){
        portalService.addVotingDetails(votingDetail);
    }
    @PostMapping("/addvotingdetailslist")
    public void addVotingDetailsList(List<VotingDetail> votingDetailList){
        portalService.addVotingDetailsList(votingDetailList);
    }
    @PostMapping("/register")
    public void registerUser(@RequestBody User user){

        portalService.registerUser(user);
    }

    @GetMapping("/getDistrictMemberDetails")
    public DistrictMemberDto loginUser(@RequestParam String phoneNumber, @RequestParam String password) {
        return portalService.loginUser(phoneNumber, password);
    }

}
