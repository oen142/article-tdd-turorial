package com.wani.articletddturorial.modules.member.domain;

import com.wani.articletddturorial.modules.common.domain.ChangeHistory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.Assert;

@NamedEntityGraph(
    name = "member-with-follows",
    attributeNodes = {
        @NamedAttributeNode("follows")
    }
)
@Entity
@Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"id", "email"})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Embedded
    private ChangeHistory changeHistory;

    private String image;
    private String bio;

    @ManyToMany
    @JoinTable(name = "member_follows",
        joinColumns = @JoinColumn(name = "follower_id"),
        inverseJoinColumns = @JoinColumn(name = "following_id"))
    private List<Member> follows = new ArrayList<>();

    private Member(Long id, String email, String username, String password,
        String image, String bio) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.image = image;
        this.bio = bio;
        this.changeHistory = new ChangeHistory();
    }

    public static Member register(String email, String username, String password) {
        verifyNotNull(username, email, password);
        return new Member(null, email, username, password, "", "");
    }

    private static void verifyNotNull(String username, String email, String password) {
        Assert.notNull(email, "email has null");
        Assert.notNull(username, "username has null");
        Assert.notNull(password, "password has null");
    }

    public void follow(Member target) {
        if( followed(target)){
            throw new ExistsMemberException();
        }
    }
}
