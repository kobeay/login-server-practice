package com.github.kobeay.login_server.dto;

import com.github.kobeay.login_server.constant.EntityStatus;
import com.github.kobeay.login_server.constant.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@SuperBuilder
public class RegisterResponse {
    private Long id;

    @Schema(description = "유저 아이디")
    private String username;

    @Schema(description = "비밀번호")
    private String password;

    @Schema(description = "역할")
    private List<Role> roles;

    @Schema(description = "계정 활성 여부")
    private EntityStatus status;

    @Schema(description = "가입일자")
    private LocalDateTime createdAt;

    @Schema(description = "수정일자")
    private LocalDateTime updateAt;
}
