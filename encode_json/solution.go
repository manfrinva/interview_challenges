package main

import (
	"encoding/json"
	"io"
)

type Manager struct {
	FullName       string `json:"full_name,omitempty"`
	Position       string `json:"position,omitempty"`
	Age            int32  `json:"age,omitempty"`
	YearsInCompany int32  `json:"years_in_company,omitempty"`
}

type Buffer struct {
	content *[]byte
}

func (buff Buffer) Read(p []byte) (int, error) {
	n := copy(p, *buff.content)
	*buff.content = (*buff.content)[n:]
	if n == 0 {
		return 0, io.EOF
	}
	return n, nil
}

func (buff Buffer) Write(p []byte) (int, error) {
	*buff.content = append(*buff.content, p...)
	return len(p), nil
}

func EncodeManager(manager *Manager) (io.Reader, error) {
	buff := Buffer{content: &[]byte{}}
	err := json.NewEncoder(buff).Encode(&manager)
	return buff, err
}
