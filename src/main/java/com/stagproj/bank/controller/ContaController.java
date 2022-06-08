package com.stagproj.bank.controller;

import com.stagproj.bank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContaController {
    @Autowired
    private ContaRepository _contaRepository;
}
