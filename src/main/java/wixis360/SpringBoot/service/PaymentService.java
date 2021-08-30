package wixis360.SpringBoot.service;

import wixis360.SpringBoot.dto.PaymentDto;

import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/
public interface PaymentService {
    void addPayment(PaymentDto dto);
    PaymentDto searchPayment(String pid);
    void updatePayment(PaymentDto dto);
    boolean deletePayment(String pid);
    ArrayList<PaymentDto> getAllPayment();
}
