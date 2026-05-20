package api.service;

import api.repository.LineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class LineServiceTest {

//    @Test
//    public void getLines() {
//        LineService lineService = mock(LineService.class);
//        when(lineService.getLines()).thenCallRealMethod();
//        assertTrue(lineService.getLines().isEmpty());
//    }

//    @Test
//    public void testses() {
//
//        LineService lineservice =  mock(LineService.class);
//        when(lineservice.getLines()).thenReturn(null);
//
//
//    }

        @Autowired
        private LineService lineService;

        @MockBean
        private LineRepository repository;

        @Test
        public void getLines() {

    }

}