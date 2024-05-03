package com.mohamed.school.response;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {

    private String name;
    private String email;
    List<Student> students;
}