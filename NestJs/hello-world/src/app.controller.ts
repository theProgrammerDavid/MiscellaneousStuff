import { Controller, Get } from '@nestjs/common';
import { AppService } from './app.service';
import { TestService } from './test.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService, private readonly testService: TestService) { }

  @Get()
  getHello(): string {
    return this.appService.getHello();
  }

  @Get("/test")
  getTest(): string {
    return this.testService.getTest();
  }
}
