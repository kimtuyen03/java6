package com.poly.luongthituyen_ph28249.service;

import com.poly.luongthituyen_ph28249.dto.KhachHangCustom;
import com.poly.luongthituyen_ph28249.dto.KhachHangRequest;
import com.poly.luongthituyen_ph28249.model.KhachHang;
import com.poly.luongthituyen_ph28249.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    public List<KhachHangCustom> getList(){
        return khachHangRepository.getAllKhachHangt();
    }

    public Page<KhachHang> getAll(Integer page){
        Pageable pageable = PageRequest.of(page, 5);
        return khachHangRepository.findAll(pageable);
    }

    public Boolean delete(Long id){
        Optional<KhachHang> optional = khachHangRepository.findById(id);
        if(optional.isPresent()){
            KhachHang kh = optional.get();
            khachHangRepository.delete(kh);
            return true;
        }else {
            return false;
        }
    }

    public KhachHang add(KhachHangRequest khachHangRequest){
        KhachHang khachHang = khachHangRequest.dto(new KhachHang());
        return khachHangRepository.save(khachHang);

    }
}
