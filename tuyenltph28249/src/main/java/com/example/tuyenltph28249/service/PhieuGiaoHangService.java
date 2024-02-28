package com.example.tuyenltph28249.service;

import com.example.tuyenltph28249.dto.PhieuGiaoHangCustom;
import com.example.tuyenltph28249.dto.PhieuGiaoHangRequest;
import com.example.tuyenltph28249.model.HoaDon;
import com.example.tuyenltph28249.model.PhieuGiaoHang;
import com.example.tuyenltph28249.repository.PhieuGiaoHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhieuGiaoHangService {

    @Autowired
    private PhieuGiaoHangRepository phieuGiaoHangRepository;

    public List<PhieuGiaoHangCustom> getAll(){
        return phieuGiaoHangRepository.getPhieuGiaoHang();
    }

    public Page<PhieuGiaoHang> getAll(Integer page){
        Pageable pageable = PageRequest.of(page, 5);
        return phieuGiaoHangRepository.findAll(pageable);
    }

//    public PhieuGiaoHang update(PhieuGiaoHangRequest phieuGiaoHangRequest, String ma){
//        Optional<PhieuGiaoHang> optional = phieuGiaoHangRepository.findById(ma);
//        return optional.map(o->{
//            o.setNguoiNhan(phieuGiaoHangRequest.getNguoiNhan());
//            o.setSdtNhan((phieuGiaoHangRequest.getSdtNhan()));
//            o.setPhiGiaoHang(phieuGiaoHangRequest.getPhiGiaoHang());
//            o.setHoaDon(HoaDon.builder().maHoaDon(Long.valueOf(phieuGiaoHangRequest.getIdhoaDon())).buid());
//            return phieuGiaoHangRepository.save(o);
//        }).orElse(null);
//    }

    public PhieuGiaoHang delete(String ma){
        Optional<PhieuGiaoHang> optional = phieuGiaoHangRepository.findById(ma);
        return optional.map(o->{
            phieuGiaoHangRepository.delete(o);
            return o;
        }).orElse(null);
    }
}
