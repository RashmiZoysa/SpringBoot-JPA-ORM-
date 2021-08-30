package wixis360.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wixis360.SpringBoot.dto.PaymentDto;
import wixis360.SpringBoot.exception.NotFoundException;
import wixis360.SpringBoot.service.PaymentService;
import wixis360.SpringBoot.utill.StandardResponse;

import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/

@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    @ResponseBody
    public ResponseEntity savePayment(@RequestBody PaymentDto dto) {
        if (dto.getPid().trim().length() <= 0) {
            throw new NotFoundException("Payment id cannot be empty");
        }
        paymentService.addPayment(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.CREATED);

    }
    @GetMapping("/{pid}")
    public @ResponseBody
    PaymentDto searchPayment(@PathVariable String pid){
        PaymentDto payment = paymentService.searchPayment(pid);
        return payment;
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity deletePayment(@PathVariable String pid){
            boolean done = paymentService.deletePayment(pid);
            return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);  }

    @PutMapping
    public ResponseEntity updatePayment(@RequestBody PaymentDto dto){
        if (dto.getPid().trim().length()<=0) {
            throw new RuntimeException("Customer Not Found...");
        }
        paymentService.updatePayment(dto);
        return new ResponseEntity(new StandardResponse("200","Done",dto),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PaymentDto> getAllPayment(){
        ArrayList<PaymentDto> allPayments = paymentService.getAllPayment();
        return new ResponseEntity(new StandardResponse("200", "Done", allPayments), HttpStatus.OK);
    }
}
