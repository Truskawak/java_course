package com.example.demo.clinic;

import com.example.demo.clinic.request.CreateAppointmentRequest;
import com.example.demo.clinic.response.AppointmentResponse;
import com.example.demo.clinic.response.DoctorResponse;
import com.example.demo.clinic.response.DoctorWithVisitsResponse;
import com.example.demo.clinic.response.PatientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/clinic")
@RequiredArgsConstructor
class ClinicController {
    private final ClinicService clinicService;
//  @GetMapping("/doctors/{id}/visits") //doktora z jego wszystkimi wizytami
    @GetMapping("/doctors/{id}")
    public DoctorResponse findDoctorById(@PathVariable @NotNull Long id) {
        return clinicService.findDoctorById(id);

    }

    @GetMapping("/doctors/{id}/visits")
    public DoctorWithVisitsResponse getDoctorWithVisits(@PathVariable @NotNull Long id) {
        return clinicService.findDoctorWithVisitsById(id);

    }


    @GetMapping("/patients/{id}")
    public PatientResponse findPatientById(@PathVariable @NotNull Long id) {
        return clinicService.findPatientById(id);

    }

    @PostMapping("/appointments/create")
    public AppointmentResponse createAppointment(@RequestBody @Valid @NotNull CreateAppointmentRequest request) {
        return clinicService.createAppointment(request);
    }
}
