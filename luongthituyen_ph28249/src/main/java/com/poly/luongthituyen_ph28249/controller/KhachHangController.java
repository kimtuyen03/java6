package com.poly.luongthituyen_ph28249.controller;

import com.poly.luongthituyen_ph28249.dto.KhachHangRequest;
import com.poly.luongthituyen_ph28249.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping()
    public ResponseEntity<?> getList(){
        return ResponseEntity.ok(khachHangService.getList());
    }

    @GetMapping("/hien-thi")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0", name = "page")int page){
        return ResponseEntity.ok(khachHangService.getAll(page));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> detete(@PathVariable Long id){
        if (khachHangService.delete(id)){
            return ResponseEntity.ok("Xoa thanh cong");
        }else {
            return ResponseEntity.ok("Xoa that bai");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid KhachHangRequest khachHangRequest, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.ok(khachHangService.add(khachHangRequest));
        }
    }
}
