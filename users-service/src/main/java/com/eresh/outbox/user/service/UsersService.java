package com.eresh.outbox.user.service;

import com.eresh.outbox.user.dao.entity.User;
import com.eresh.outbox.user.dao.repository.UserRepository;
import com.eresh.outbox.user.dto.CreateNewsLetterSubscriptionDTO;
import com.eresh.outbox.user.dto.CreateUserDTO;
import com.eresh.outbox.user.dto.UpdateEmailDTO;
import com.eresh.outbox.user.dto.UserDTO;
import com.eresh.outbox.user.outbox.OutboxEventsUtil;
import com.eresh.outbox.user.outbox.OutboxPublisher;
import com.eresh.outbox.user.util.DTOConversionUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created on 17/August/2021 By Author Eresh, Gorantla
 **/
@Service
@RequiredArgsConstructor
public class UsersService {

	private final UserRepository usersRepository;
	private final OutboxPublisher outboxPublisher;

	@Transactional
	public UserDTO createUser(CreateUserDTO dto) {
		User user = DTOConversionUtil.toUsers(dto);
		user = usersRepository.save(user);
		UserDTO usersDTO = DTOConversionUtil.toUsersDTO(user);
		outboxPublisher.publishEvent(OutboxEventsUtil.createNewUserEvent(usersDTO));
		return usersDTO;
	}

	public void createNewsLetterSubscriptions(CreateNewsLetterSubscriptionDTO subscriptionDTO) {
		Optional<User> userOptional = usersRepository.findById(subscriptionDTO.getUserId());
		if (userOptional.isEmpty()) {
			throw new RuntimeException("The id can not be found => "+subscriptionDTO.getUserId());
		}
		User user = userOptional.get();
		outboxPublisher.publishEvent(OutboxEventsUtil.createNewsletterSubscriptions(
				DTOConversionUtil.subscriptionsEventDTO(user, subscriptionDTO)));
	}

	public UserDTO updateUserEmail(UpdateEmailDTO dto, String id) {
		Optional<User> userOptional = usersRepository.findById(id);
		if (userOptional.isEmpty()) {
			throw new RuntimeException("The id can not be found => "+id);
		}
		User user = userOptional.get();
		user.setEmail(dto.getEmail());
		UserDTO usersDTO = DTOConversionUtil.toUsersDTO(user);
		outboxPublisher.publishEvent(OutboxEventsUtil.createEmailUpdatedEvent(usersDTO));
		return usersDTO;
	}
}