/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.allure.suite;

import com.example.allure.tests.Tests;
import org.junit.runner.RunWith;

/**
 *
 * @author vlatko
 */
@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({ 
    Tests.class
    })
public class Suite {
    
}
