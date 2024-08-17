package org.example.virtualfittingshop.domain.image.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Image {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    private String filename;
    private String fileOriginName;
    private String fileExtension;
    private String fileUrl;
}
