import { Controller, Get } from '@nestjs/common';

@Controller('car')
export class CarController {

    @Get("t")
    helloCar(): {} {
        return { msg: 'hello this is a car' };
    }
}
