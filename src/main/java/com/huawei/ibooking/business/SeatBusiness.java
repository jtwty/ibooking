package com.huawei.ibooking.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatBusiness{

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    // 添加Seat
    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    // 获取所有Seat
    public Iterable<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    // 根据ID获取Seat
    public Optional<Seat> getSeatById(Long id) {
        return seatRepository.findById(id);
    }

    // 更新Seat
    public Seat updateSeat(Seat updatedSeat) {
        if (!seatRepository.existsById(updatedSeat.getId())) {
            throw new ResourceNotFoundException("Seat", "id", updatedSeat.getId());
        }
        return seatRepository.save(updatedSeat);
    }

    // 删除Seat
    public void deleteSeat(Long id) {
        if (!seatRepository.existsById(id)) {
            throw new ResourceNotFoundException("Seat", "id", id);
        }
        seatRepository.deleteById(id);
    }
}

// ResourceNotFoundException 是自定义异常，用于资源未找到的情况
