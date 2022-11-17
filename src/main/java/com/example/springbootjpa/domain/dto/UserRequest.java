package com.example.springbootjpa.domain.dto;

import com.example.springbootjpa.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String username;
    private String password;

    public User toEntity() { // -> Article에 @Builder 추가
        User user = User.builder()
                .username(this.username)
                .password(this.password) // title, content 두 개만 넣고도 article 구성 가능 -> @Builder로 인해
                .build();
        return user;
    }
}
