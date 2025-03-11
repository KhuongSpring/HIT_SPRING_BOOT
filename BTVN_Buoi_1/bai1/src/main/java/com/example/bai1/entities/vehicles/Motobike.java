package com.example.bai1.entities.vehicles;

import com.example.bai1.services.interfaces.IVehicleService;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Motobike{
    String name;
}
