package wixis360.SpringBoot.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wixis360.SpringBoot.dto.PaymentDto;
import wixis360.SpringBoot.entity.Payment;
import wixis360.SpringBoot.exception.ValidateException;
import wixis360.SpringBoot.repo.PaymentRepo;
import wixis360.SpringBoot.service.PaymentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addPayment(PaymentDto dto) {
        if (paymentRepo.existsById(dto.getPid())) {
            throw new ValidateException("User Already Exists...");
        }
        paymentRepo.save(mapper.map(dto, Payment.class));

    }

    @Override
    public PaymentDto searchPayment(String pid) {
        Optional<Payment> payment = paymentRepo.findById(pid)
                ;
        if (payment.isPresent()) {
            return mapper.map(payment.get(), PaymentDto.class);
        }
        return null;    }

    @Override
    public void updatePayment(PaymentDto dto) {
        if (paymentRepo.existsById(dto.getPid())) {
            paymentRepo.save(mapper.map(dto, Payment.class));

        }
    }

    @Override
    public boolean deletePayment(String pid) {
        if (!paymentRepo.existsById(pid)) {
            throw new ValidateException("No Payment for Delete..!");
        }
        paymentRepo.deleteById(pid);
        return true;
    }

    @Override
    public ArrayList<PaymentDto> getAllPayment() {
        List<Payment> all = paymentRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<PaymentDto>>() {
        }.getType());
    }
}



