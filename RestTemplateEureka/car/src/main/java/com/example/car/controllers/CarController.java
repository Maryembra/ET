package com.example.car.controllers;

import com.example.car.entities.Car;
import com.example.car.models.CarResponse;
import com.example.car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarResponse> findAll() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public CarResponse findById(@PathVariable Long id) throws Exception {
        return carService.findById(id);
    }
        @PostMapping
        public ResponseEntity<CarResponse> saveCar(@RequestBody Car car) {
            try {
                CarResponse carResponse = carService.saveCar(car);
                return ResponseEntity.ok(carResponse);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(null);
            }
        }
}
