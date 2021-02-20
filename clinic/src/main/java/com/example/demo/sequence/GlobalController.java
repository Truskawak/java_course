package com.example.demo.sequence;

import com.example.demo.sequence.dto.DecodePeselRequest;
import com.example.demo.sequence.dto.DecodePeselResponse;
import com.example.demo.sequence.dto.SequenceRequest;
import com.example.demo.sequence.dto.SequenceResponse;
import com.example.demo.sequence.dto.SequenceType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
class GlobalController {

    private final SequenceService sequenceService;
    private final PeselService peselService;

    @ResponseStatus(OK)
    @PostMapping("/sequence")
    public ResponseEntity<SequenceResponse> identifySequence(@RequestBody @Valid SequenceRequest request) {

        SequenceType sequenceType = sequenceService.identifySequenceType(request.getNumbers());

        return ResponseEntity.ok(new SequenceResponse(sequenceType));
    }

    @ResponseStatus
    @PostMapping("/pesel")
    public ResponseEntity<DecodePeselResponse> decodePesel(@RequestBody @Valid DecodePeselRequest request) {
        DecodePeselResponse response = peselService.decodePesel(request);
        return ResponseEntity.ok(response);

    }



     /*
    PeselController
    @Post { "pesel": pesel}
    validowany:
    400 - invalid length or characters
    400 - invlid control sum
    200ok {"birthDate": ..., "gender": ...}

    constraint validation
     */
}
