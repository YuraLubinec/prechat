package com.oblenergo.chatBot.services;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oblenergo.chatBot.dto.IndicatorDTO;
import com.oblenergo.chatBot.dto.IndicatorResponseDTO;

@Service
public class IndicatorServiceImpl implements IndicatorService {

	private static final String DEFAULT_ERROR_MESSAGE = "Показник внесено невірно, просимо уточнити показник";

	@Value("${indicator.service.url}")
	private String url;

	@Value("${begin.period.date}")
	private int beginPeriodDate;

	@Value("${end.period.date}")
	private int endPeriodDate;

	@Override
	public ResponseEntity<String> saveIndicator(IndicatorDTO indicator) {

		if (checkPeriod()) {
			RestTemplate template = new RestTemplate();
			HttpEntity<IndicatorDTO> request = new HttpEntity<>(indicator);
			IndicatorResponseDTO responseDTO = template.postForObject(url, request, IndicatorResponseDTO.class);
			if (responseDTO.getAnswer() != null) {
				return new ResponseEntity<String>(responseDTO.getAnswer(), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(DEFAULT_ERROR_MESSAGE, HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<String>("Avaialble only from 20 to 3 of the month", HttpStatus.OK);
		}
	}

	private boolean checkPeriod() {

		LocalDate localDateNow = LocalDate.now();
		int month = localDateNow.getMonthValue();
		if (localDateNow.getMonth().equals(Month.DECEMBER)) {
			LocalDate endDateExclusive = LocalDate.of(localDateNow.getYear(), Month.JANUARY, endPeriodDate);
			LocalDate startDateInclusive = LocalDate.of(localDateNow.getYear(), month, beginPeriodDate);
			return localDateNow.isBefore(endDateExclusive) && localDateNow.isAfter(startDateInclusive);
		} else {
			LocalDate endDateExclusive = LocalDate.of(localDateNow.getYear(), month + 1, endPeriodDate);
			LocalDate startDateInclusive = LocalDate.of(localDateNow.getYear(), month, beginPeriodDate);
			return localDateNow.isBefore(endDateExclusive) && localDateNow.isAfter(startDateInclusive);
		}
	}
}
