package com.example.demo.sequence;

import com.example.demo.sequence.dto.SequenceType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.function.IntBinaryOperator;

@Service
class SequenceService {

    SequenceType identifySequenceType(List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        SequenceType result;
        if (isArithmetic(numbers)) {
            result = SequenceType.ARITHMETIC;
        } else if (isGeometric(numbers)) {
            result = SequenceType.GEOMETRIC;
        } else {
            result = SequenceType.UNKNOWN;
        }

        return result;

    }

    private boolean isArithmetic(List<Integer> numbers) {
        IntBinaryOperator arithmeticOperation = (a, b) -> b - a;
        return isExpectedSeqType(numbers, arithmeticOperation);
    }

    private boolean isGeometric(List<Integer> numbers) {
        IntBinaryOperator geometricOperation = (a, b) -> b / a;
        return isExpectedSeqType(numbers, geometricOperation);
    }

    private boolean isExpectedSeqType(List<Integer> numbers, IntBinaryOperator seqOperation) {
        if (numbers.size() < 2) return false;
        boolean isExpectedSeqType = true;
        int seqParam = seqOperation.applyAsInt((numbers.get(0)), numbers.get(1));

        for (int i = 0; i < numbers.size() - 1; i++) {
            Integer current = numbers.get(i);
            Integer next = numbers.get(i + 1);
            if (seqOperation.applyAsInt(current, next) != seqParam) {
                isExpectedSeqType = false;
                break;
            }
        }
        return isExpectedSeqType;
    }
}
