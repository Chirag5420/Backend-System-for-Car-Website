package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PricingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PricingController.class)
public class PricingControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    PricingService priceService;

    @Test
    public void getPrice() throws Exception {
        mockMvc.perform(get("/services/price?vehicleId=1"))
                .andExpect(status().isOk());

        verify(priceService, times(1)).getPrice(1L);
    }
}
