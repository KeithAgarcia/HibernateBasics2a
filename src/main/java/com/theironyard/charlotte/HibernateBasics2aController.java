package com.theironyard.charlotte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Keith on 5/9/17.
 */

@Controller
public class HibernateBasics2aController {
    @Autowired
     MessageRepository messages;

//    ArrayList<Message> messages = new ArrayList<>();
//    It should take the model and the request as arguments
//    It should read the username from the session and add it to the model
//    It should return the home template


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        // we need references to the current session
        // and the model to render this page.

        // add the name attribute to the model. set it to whatever
        // we get from session.
        model.addAttribute("userName", session.getAttribute("userName"));
        model.addAttribute("messages", messages.findAll());
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        // userName comes from the form. MUST MATCH
        // THE NAME ATTRIBUTE ON THE FORM ITSELF
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String postMessage(String messageText) {
        Message message = new Message(messageText);
        messages.save(message);

        // make a new message object
        // put the message object in our arraylist
        // redirect back to the homepage.
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(HttpSession session, int id) { //id is the name of the delete-message in template home.html.

                messages.delete(id);
        // make a new message object
        // put the message object in our arraylist
        // redirect back to the homepage.
        return "redirect:/";
    }

}
