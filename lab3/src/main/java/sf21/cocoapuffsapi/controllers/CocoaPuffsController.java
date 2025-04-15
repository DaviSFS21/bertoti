package sf21.cocoapuffsapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sf21.cocoapuffsapi.entities.CocoaPuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cocoa_puffs")
public class CocoaPuffsController {
    private List<CocoaPuff> cocoaPuffs = new ArrayList<>();

    public CocoaPuffsController() {
        System.out.println("passei aqui");
        cocoaPuffs.addAll(List.of(
                new CocoaPuff("cp1"),
                new CocoaPuff("sim"),
                new CocoaPuff("depende")
        ));
    }

    @GetMapping
    Iterable<CocoaPuff> getCocoaPuffs() {
        return cocoaPuffs;
    }

    @GetMapping("/{id}")
    Optional<CocoaPuff> getCocoaPuffById(@PathVariable String id) {
        for (CocoaPuff cp: cocoaPuffs) {
            if (cp.getId().equals(id)) {
                return Optional.of(cp);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    CocoaPuff postCocoaPuff(@RequestParam String name) {
        CocoaPuff cp = new CocoaPuff(name);
        cocoaPuffs.add(cp);
        return cp;
    }

    @PutMapping("/{id}")
    ResponseEntity<CocoaPuff> putCocoaPuff(@PathVariable String id,
                                           @RequestParam String name) {

        System.out.println(name);

        CocoaPuff cocoaPuff = new CocoaPuff(name);
        int cocoaPuffIndex = -1;

        for (CocoaPuff cp: cocoaPuffs) {
            if (cp.getId().equals(id)) {
                cocoaPuffIndex = cocoaPuffs.indexOf(cp);
                cocoaPuffs.set(cocoaPuffIndex, cocoaPuff);
            }
        }

        return (cocoaPuffIndex == -1) ?
                new ResponseEntity<>(postCocoaPuff(name), HttpStatus.CREATED) :
                new ResponseEntity<>(cocoaPuff, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteCocoaPuff(@PathVariable String id) {
        cocoaPuffs.removeIf(cp -> cp.getId().equals(id));
    }
}
