package project.se.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.se.demo.entity.*;
import project.se.demo.repository.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ShopController {
    @Autowired private final ShopRepository shopRepository;
    @Autowired private ItemRepository itemRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private DistrictRepository districtRepository;

    @Autowired
    ShopController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @GetMapping("/Shops")
    public Collection<Shop> Shop() {
        return shopRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/Shop/{id}")
    public Optional<Shop> View(@PathVariable Long id) {
        Optional<Shop> S = shopRepository.findById(id);
        return S;
    }


    @PostMapping("/Customer/add/{username}/{customerName}/{tel}/{email}/{subdist}/{itemId}?/{districtId}")
    public Shop newShop(@PathVariable String usernamme ,@PathVariable String customerName, @PathVariable String tel, @PathVariable String email, @PathVariable String subdist
                                , @PathVariable Long itemId, @PathVariable long districtId ){
        Shop newShop = new Shop();
        Customer customer = new Customer();
        Item item = itemRepository.findByItemId(itemId);
        District district = districtRepository.findById(districtId);

        customer.setUsername(usernamme);
        customer.setCustomerName(customerName);
        customer.setTel(tel);
        customer.setEmail(email);
        customerRepository.save(customer);


        newShop.setSubdist(subdist);
        newShop.setItem(item);
        newShop.setDistrictShop(district);
        newShop.setCustomerShop(customer);
        return shopRepository.save(newShop);
    }


}
