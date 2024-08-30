package com.eventiX.api.controller;

import com.eventiX.api.domain.coupon.Coupon;
import com.eventiX.api.domain.coupon.CouponRequestDTO;
import com.eventiX.api.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/event/{eventId}")
    public ResponseEntity<Coupon> addCoupons(@PathVariable UUID eventId, @RequestBody CouponRequestDTO data){
        Coupon coupons = couponService.addCouponToEvent(eventId, data);
        return ResponseEntity.ok(coupons);
    }

}
