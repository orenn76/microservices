package com.ninyo.triangle.service;

import com.ninyo.triangle.model.State;
import com.ninyo.triangle.model.TriangleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class AlgoService {

    @Value("${scheduledJob.enabled:false}")
    private boolean scheduledJobEnabled;

    @Autowired
    private TriangleService triangleService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //@Scheduled(fixedRate = 20000) // every 20 seconds
    public void execute() {
        if (scheduledJobEnabled) {
            log.info("AlgoService started at " + dateFormat.format(new Date()));

            List<TriangleDto> triangleDtoList = triangleService.readAll();

            List<TriangleDto> updatedTriangleDtoList = triangleDtoList.stream().filter(triangleDto -> triangleDto.getState() == State.PRE_CALC).map(triangleDto -> {
                triangleDto.setHypotenuse((int)Math.pow(triangleDto.getAdjacent(), 2) + (int)Math.pow(triangleDto.getOpposite(), 2));
                triangleDto.setState(State.POST_CALC);
                triangleService.update(triangleDto.getId(), triangleDto);
                return triangleDto;
            }).collect(Collectors.toList());

            log.info("AlgoService updated TriangleDto list of size {} and finished at {}", updatedTriangleDtoList.size(), dateFormat.format(new Date()));
        }
    }

}
