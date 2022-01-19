/*
 * IModelConverter.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
 Created: 10/1/21 3:56 PM
*/
package com.muhendisbey.whocalledme.whocalledmeservice.converter;

import com.muhendisbey.whocalledme.whocalledmeservice.dto.AvailableNowDTO;
import com.muhendisbey.whocalledme.whocalledmeservice.dto.MissedCallDTO;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageConverter implements IMessageConverter
{
    private final static String MISSING_CALL_MSG_KEY = "call.missing";
    private final static String AVAILABLE_NOW_MSG_KEY = "call.availability";

    private final MessageSource messageSource;

    public MessageConverter(MessageSource messageSource)
    {
        this.messageSource = messageSource;
    }

    @Override
    public String toString(MissedCallDTO dto)
    {
        final String[] params = {dto.getWho() + dto.getWhen() + dto.getHowMany()};

        return messageSource.getMessage(MISSING_CALL_MSG_KEY, params,
                LocaleContextHolder.getLocale());
    }

    @Override
    public String toString(AvailableNowDTO dto)
    {
        final String[] params = {dto.getCalledNumber(), dto.getCalledDate()};

        return messageSource.getMessage(AVAILABLE_NOW_MSG_KEY, params,
                LocaleContextHolder.getLocale());
    }
}
