package com.oblenergo.chatBot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oblenergo.chatBot.models.Statistic;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {

}
