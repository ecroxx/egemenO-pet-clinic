package com.example.egemenOpetclinic.Controllers;

import com.example.egemenOpetclinic.model.Owner;
import com.example.egemenOpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {


    @InjectMocks
    private OwnerController ownerController;
    @Mock
    private OwnerService ownerService;
    @Mock
    private Model model;

    MockMvc controllerTest;
    private Set<Owner> owners;
    private String returnString="owners/index";
    ArgumentCaptor <Set<Owner>> argumentCaptor=ArgumentCaptor.forClass(Set.class);

    @BeforeEach
    void setUp() {
        owners=new HashSet<>();
        owners.add(Owner.builder().id(1l).build());
        owners.add(Owner.builder().id(2l).build());
        controllerTest=MockMvcBuilders.standaloneSetup(ownerController).build();

    }

    @Test
    void MockMVClistOwnersByIndex() throws Exception{
        when(ownerService.findAll()).thenReturn(owners);

        controllerTest.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(2)));
    }



    @Test  //same result with MockMVClistOwners() which is more practical one
    void listOwners() {
       //given
        when(ownerService.findAll()).thenReturn(owners);

        //when
        String when=ownerController.listOwners(model);

        //then
        assertEquals(returnString,when);
        verify(ownerService).findAll();
        verify(model).addAttribute(eq("owners"),argumentCaptor.capture());

        Set<Owner> set=argumentCaptor.getValue();
        assertEquals(2,set.size());

    }

    @Test
    void MockMVCfindOwners() throws Exception{
        controllerTest.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));

        verifyZeroInteractions(ownerService);

    }





    @Test
    void processFindFormReturnOne() throws Exception {
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Owner.builder().id(1l).build()));

        controllerTest.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
    }

    @Test
    void processFindFormEmptyReturnMany() throws Exception {
        when(ownerService.findAllByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(Owner.builder().id(1l).build(),
                        Owner.builder().id(2l).build()));

        controllerTest.perform(get("/owners")
                .param("lastName",""))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));;
    }







    @Test
    void showOwnersTest() throws Exception{
        Owner owner=Owner.builder().id(3L).build();
        when(ownerService.findById(anyLong())).thenReturn(owner);
        controllerTest.perform(get("/owners/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner",hasProperty("id",is(3L))));
    }


}