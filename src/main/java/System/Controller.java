package System;

import org.springframework.web.bind.annotation.*;
import  java.util.*;

@RestController
@RequestMapping("/users")
public class Controller {
    private static List<Users> usersList = new ArrayList<>();
    private static List<Cards> cardsList = new ArrayList<>();

    @PostMapping("/createUser")
    public List<Users> creatingUser(@RequestBody Users users){
        Users newUser = Users.builder()
                .id(users.getId())
                .userId(users.getUserId())
                .name(users.getName())
                .surname(users.getSurname())
                .email(users.getEmail())
                .cards(users.getCards())
                .build();
        usersList.add(newUser);
        return usersList;
    }

    @PostMapping("/createCard")
    public List<Cards> createCard(@RequestBody Cards cards){
        Cards cards1 = Cards.builder()
                .id(cards.getId())
                .cardNumber(cards.getCardNumber())
                .balance(cards.getBalance())
                .userId(cards.getUserId())
                .isActive(cards.isActive())
                .build();
        cardsList.add(cards1);
        return cardsList;
    }

    @GetMapping("/mycard")
    public List<Cards> mycards (@PathVariable int userID){
        List<Cards> mycardsList = new ArrayList<>();
        for (Cards card : cardsList){
            if(card.getId()==userID){
                mycardsList.add(card);
            }
            else {
                throw new RuntimeException("No such ID: " + userID);
            }
        }
        return mycardsList;
    }

    @GetMapping("/allUsers")
    public List<Users> getAllUsers() {
        return usersList;
    }

    @GetMapping("/allCards")
    public List<Cards> getAllCreditCards() {
        for (Cards cards : cardsList) {
            System.out.println(cards);
        }
        throw new RuntimeException("Not exists card");
    }

    @PostMapping("/blockingCard/{id}")
    public Cards blockCard(@PathVariable int id, @RequestParam boolean status){
        for (Cards cards : cardsList){
            if (cards.getId()==id){
                cards.setActive(status);
                return cards;
            }
        }
        throw new RuntimeException("No such card for block");
    }
    @DeleteMapping("/delete/{id}")
    public List<Cards> deletingUser(@PathVariable long id){
        for (Cards cards : cardsList){
            if (cards.getId()==id){
                cardsList.remove(cards);
            }
        }
        return cardsList;
    }

}
