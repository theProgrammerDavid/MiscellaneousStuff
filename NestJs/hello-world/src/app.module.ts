import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { TestService } from './test.service';
import { CarController } from './car/car.controller';

@Module({
  imports: [],
  controllers: [AppController, CarController],
  providers: [AppService, TestService],
})
export class AppModule { }
