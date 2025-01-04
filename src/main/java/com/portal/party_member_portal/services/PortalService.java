package com.portal.party_member_portal.services;



import com.portal.party_member_portal.dto.DistrictMemberDto;
//import com.portal.party_member_portal.dto.MemberDto;
import com.portal.party_member_portal.entities.*;
import com.portal.party_member_portal.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import static com.portal.party_member_portal.utilities.ApplicationConstants.DISTRICT_MEMBER;

@Service
public class PortalService {
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    TalukRepository talukRepository;
    @Autowired
    GramPanchayatRepository gramPanchayatRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    CustomUserRepository userRepository;
    @Autowired
    PollingStationDetailRepository pollingStationDetailRepository;
    @Autowired
    VotingDetailRepository votingDetailRepository;

    public void addDistrict(District district) {

       List<Taluk> talukList = district.getTalukList();
       for(Taluk taluk : talukList){
           taluk.setDistrict(district);
           List<GramPanchayat> gramPanchayatList = taluk.getGramPanchayatList();
           for(GramPanchayat gramPanchayat : gramPanchayatList){
               gramPanchayat.setTaluk(taluk);
           }
       }
        districtRepository.save(district);
    }
    public void addAllDistricts(List<District> districts) {
        for(District district : districts) {
            List<Taluk> talukList = district.getTalukList();
            for (Taluk taluk : talukList) {
                taluk.setDistrict(district);
                List<GramPanchayat> gramPanchayatList = taluk.getGramPanchayatList();
                for (GramPanchayat gramPanchayat : gramPanchayatList) {
                    gramPanchayat.setTaluk(taluk);
                }
            }
        }
        districtRepository.saveAll(districts);
    }

    public void addTaluk(Taluk taluk) {
        talukRepository.save(taluk);
    }
    public void addAlltaluks(List<Taluk> taluks) {
        talukRepository.saveAll(taluks);
    }
    public void addTaluks(@PathVariable int districtId,  @RequestBody List<Taluk> taluks){
         Optional<District> district= districtRepository.findById(districtId);
         if(district.isPresent()){
        for (Taluk taluk : taluks) {
            taluk.setDistrict(district.get());
        }}
         talukRepository.saveAll(taluks);
    }
    public void addGramPanchayat(GramPanchayat gramPanchayat) {
        gramPanchayatRepository.save(gramPanchayat);
    }

    public void addGramPanchayats(List<GramPanchayat> gramPanchayats) {
        gramPanchayatRepository.saveAll(gramPanchayats);
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }

    public void addRoles(List<Role> roles) {
        roleRepository.saveAll(roles);
    }

    public void addPollingStationDetails(PollingStationDetail pollingStationDetail) {
        pollingStationDetailRepository.save(pollingStationDetail);
    }

    public void addPollingStationsDeatils(List<PollingStationDetail> pollingStationDetailList) {
        pollingStationDetailRepository.saveAll(pollingStationDetailList);
    }

    public void addVotingDetails(VotingDetail votingDetail) {
        votingDetailRepository.save(votingDetail);
    }

    public void addVotingDetailsList(List<VotingDetail> votingDetailList) {
        votingDetailRepository.saveAll(votingDetailList);
    }

    public void registerUser(User user) {

        Role role = user.getRole();
        Role role1 = roleRepository.findByName(role.getName());
        role1.setUser(user);
        user.setRole(role1);

        if (DISTRICT_MEMBER.equalsIgnoreCase(role1.getName())){
            District district = user.getDistrict();
            District district1 = districtRepository.findByName(district.getName());
            user.setDistrict(district1);
        } else if ("taluk member".equalsIgnoreCase(role1.getName())) {
            Taluk taluk = user.getTaluk();
            Taluk taluk1 = talukRepository.findByName(taluk.getName());
            user.setTaluk(taluk1);
        }
        else if("gramPanchayat member".equalsIgnoreCase(role1.getName())){
            GramPanchayat gramPanchayat = user.getGramPanchayat();
            GramPanchayat gramPanchayat1 = gramPanchayatRepository.findByName(gramPanchayat.getName());
            user.setGramPanchayat(gramPanchayat1);
        }

        userRepository.save(user);

    }

public DistrictMemberDto loginUser(String phoneNumber, String password) {
    // Fetch the user based on the phone number
    User user = userRepository.findByPhoneNumber(phoneNumber);

    // Validate user and password
    if (user != null && password.equals(user.getPassword())) {
        Role role = user.getRole();
        if (role != null) {
            Optional<Role> optionalRole = roleRepository.findById(role.getId());
            if (optionalRole.isPresent() && DISTRICT_MEMBER.equals(optionalRole.get().getName())) {
                // Fetch and return district member details
                return userRepository.findDistrictMemberDetails(phoneNumber);
            }
        }
    }

    // If authentication fails or user is not a district member, throw an exception or return null
    throw new IllegalArgumentException("Invalid phone number, password, or user role");
}}