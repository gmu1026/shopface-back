package com.dreamsecurity.shopface.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SampleApiServiceImpl implements SampleApiService {
    private final SampleMapper sampleMapper;

    @Override
    public Sample getSample(Long no) {
         return sampleMapper.select(no);
    }

    @Override
    public List<Sample> getSamplelist() {
        return sampleMapper.selectAll();
    }
}
