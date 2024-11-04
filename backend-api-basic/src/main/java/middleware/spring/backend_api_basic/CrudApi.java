package middleware.spring.backend_api_basic;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/crud")
public class CrudApi {
    // Storage: collections, temporary
    private List<String> mySkills=Stream.of("Java","Python","DJango","MongoDB").collect(Collectors.toList());

    @PutMapping("/{index}")
    public String update(@PathVariable("index") int index,@RequestBody String replacable){
        if(index>0&&index<mySkills.size()){
            
            return replacable+" has been updated @ "+index;
        }
        return replacable+" hasn't been updated @ "+index;
    }

    @DeleteMapping("/{position}")
    public String erase(@PathVariable("position") int position){
        mySkills.remove(position);
        return position+" data has been removed from your skill set";
    }

    @PostMapping("/")
    public String newOne(@RequestBody String newSkill){
        mySkills.add(newSkill);
        return newSkill+" has added with your skill set";
    }
    
    @GetMapping("/")
    public List<String> viewSkills(){
        return mySkills;
    }
}
