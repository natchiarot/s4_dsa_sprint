package com.keyin.dsa.test;

import com.keyin.dsa.numbers.Number;
import com.keyin.dsa.numbers.NumberController;
import com.keyin.dsa.numbers.NumberService;
import com.keyin.dsa.tree.Tree;
import com.keyin.dsa.tree.TreeController;
import com.keyin.dsa.tree.TreeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest({NumberController.class, TreeController.class})
public class RestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private NumberService numberService;

    @MockBean
    private TreeService treeService;

    @Test
    public void givenNumbers_whenGetNumbers_thenReturnJsonArray()
            throws Exception {
        String numberInput = "1 23 43 54 4";
        Number num = new Number(numberInput);

        List<Number> allNumbers = Arrays.asList(num);

        given(numberService.getAllNumbers()).willReturn(allNumbers);

        mvc.perform(get("/numbers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].numberInput", is(num.getNumberInput())));
    }

    @Test
    public void givenTree_whenGetTree_thenReturnJsonArray()
            throws Exception {
        int value = 5;
        Tree val = new Tree(value);

        List<Tree> allTrees = Arrays.asList(val);

        given(treeService.getAllTrees()).willReturn(allTrees);

        mvc.perform(get("/trees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].value", is(val.getValue())));
    }
}
