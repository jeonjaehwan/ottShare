package com.project.ottshare.service;

import com.project.ottshare.dto.ottShareRoomDto.MessageRequest;
import com.project.ottshare.dto.ottShareRoomDto.MessageResponse;
import com.project.ottshare.entity.Message;
import com.project.ottshare.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MessageService {

    private final MessageRepository messageRepository;

    @Transactional
    public void createMessage(MessageRequest messageRequest) {
        Message entity = Message.from(messageRequest);
        messageRepository.save(entity);
    }

    public Page<MessageResponse> getMessages(Long roomId) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());
        Page<Message> messages = messageRepository.findAllByOttShareRoomIdOrderByCreatedDate(roomId, pageable);
        return messages.map(MessageResponse::from);
    }


}
