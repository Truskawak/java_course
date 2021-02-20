package com.example.demo.sequence;

import com.example.demo.sequence.dto.DecodePeselRequest;
import com.example.demo.sequence.dto.DecodePeselResponse;
import com.example.demo.sequence.dto.Gender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
class PeselService {

    DecodePeselResponse decodePesel(DecodePeselRequest request) {
        LocalDate birthDate = getBirthDate(request.getPesel());
        Gender gender = getGender(request.getPesel());

        return new DecodePeselResponse(birthDate, gender);
    }

    private static LocalDate getBirthDate(String pesel) {
        int month = Integer.parseInt(pesel.substring(2, 4));
        int year = Integer.parseInt(pesel.substring(0, 2));
        int day = Integer.parseInt(pesel.substring(4, 6));

        if (month > 80) {
            year = 1800 + year;
            month = month - 80;
        } else if (month > 60) {
            year = 2200 + year;
            month = month - 60;
        } else if (month > 40) {
            year = 2100 + year;
            month = month - 40;
        } else if (month > 20) {
            year = 2000 + year;
            month = month - 20;
        } else {
            year = 1900 + year;
        }

        return LocalDate.of(year, month, day);
    }

    private Gender getGender(String pesel) {
        if (Character.getNumericValue(pesel.charAt(9)) % 2 == 1) {
            return Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }
}
