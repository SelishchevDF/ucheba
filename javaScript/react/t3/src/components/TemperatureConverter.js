import * as React from "react";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import { useState } from "react";

function TemperatureConverter() {
    const [temperatureCel, setTemperatureCel] = useState("");
    const [temperatureFar, setTemperatureFar] = useState("");

    function convertToTemperatureCel(f) {
        const c = (parseFloat(f) - 32) * (5 / 9);
        setTemperatureCel(c);
    };

    function convertToTemperatureFar(c) {
        const f = (parseFloat(c) * 9) / 5 + 32;
        setTemperatureFar(f);
    }

    function handleTemperatureCelChange(e) {
        const { value } = e.target;
        setTemperatureCel(value);
        convertToTemperatureFar(value);
    }

    function handleTemperatureFarChange(e) {
        const { value } = e.target;
        setTemperatureFar(value);
        convertToTemperatureCel(value);
    };

    return (
        <div>
            <TextField
                variant="standard"
                label="Цельсий"
                value={temperatureCel}
                onChange={handleTemperatureCelChange}
            />
            <TextField
                variant="standard"
                label="Фаринейт"
                value={temperatureFar}
                onChange={handleTemperatureFarChange}
            />
            <Button
                variant="contained"
                onClick={
                    () => {
                        setTemperatureCel("");
                        setTemperatureFar("");
                    }
                }
            >
                Очистить
            </Button>
        </div>
    );
};

export default TemperatureConverter;