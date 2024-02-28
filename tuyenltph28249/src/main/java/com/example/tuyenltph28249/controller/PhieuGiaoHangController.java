package com.example.tuyenltph28249.controller;

import com.example.tuyenltph28249.dto.PhieuGiaoHangRequest;
import com.example.tuyenltph28249.model.PhieuGiaoHang;
import com.example.tuyenltph28249.service.PhieuGiaoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/phieuGiaoHang")
public class PhieuGiaoHangController {

    @Autowired
    private PhieuGiaoHangService phieuGiaoHangService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(phieuGiaoHangService.getAll());
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0", name = "page")Integer page){
        return ResponseEntity.ok(phieuGiaoHangService.getAll(page));
    }

//    @PutMapping("/update/{ma}")
//    public ResponseEntity<?> update(@PathVariable String ma, @RequestBody PhieuGiaoHangRequest phieuGiaoHangRequest){
//        return ResponseEntity.ok(phieuGiaoHangService.update(phieuGiaoHangRequest, ma));
//    }

    @DeleteMapping("/delete/{ma}")
    public ResponseEntity<?> delete(@PathVariable String ma){
        return ResponseEntity.ok(phieuGiaoHangService.delete(ma));
    }



}
