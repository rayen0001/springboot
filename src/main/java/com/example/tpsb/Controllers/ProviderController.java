package com.example.tpsb.Controllers;

import com.example.tpsb.Models.Provider;
import com.example.tpsb.Services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    // Show all providers
    @GetMapping
    public String listProviders(Model model) {
        List<Provider> providers = providerService.getAllProviders();
        model.addAttribute("providers", providers);
        return "providers/list"; // Thymeleaf template name
    }

    // Show form to create a new provider
    @GetMapping("/new")
    public String showCreateProviderForm(Model model) {
        model.addAttribute("provider", new Provider());
        return "providers/create"; // Thymeleaf template name for the form
    }

    // Save a new provider
    @PostMapping
    public String createProvider(@ModelAttribute("provider") Provider provider) {
        providerService.saveProvider(provider);
        return "redirect:/providers"; // Redirect after saving
    }

    // Show form to edit an existing provider
    @GetMapping("/edit/{id}")
    public String showEditProviderForm(@PathVariable("id") Long id, Model model) {
        Provider provider = providerService.getProviderById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
        model.addAttribute("provider", provider);
        return "providers/edit"; // Thymeleaf template name for the form
    }

    // Update an existing provider
    @PostMapping("/update/{id}")
    public String updateProvider(@PathVariable("id") Long id, @ModelAttribute("provider") Provider provider) {
        provider.setId(id); // Ensure the ID is set for the update
        providerService.saveProvider(provider);
        return "redirect:/providers"; // Redirect after updating
    }

    // Delete a provider
    @GetMapping("/delete/{id}")
    public String deleteProvider(@PathVariable("id") Long id) {
        providerService.deleteProviderById(id);
        return "redirect:/providers"; // Redirect after deleting
    }
}
